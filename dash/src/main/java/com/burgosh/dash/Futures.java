package com.burgosh.dash;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

/*         No need to be multithreaded;           *
 * Futures are already a multithreaded component, *
 *     the only responsibility of this class      *
 *       is to wait for the list of futures       *
 *                                                *
 *      No need to return CompletableFuture;      *
 *           Once you call this method            *
 *            you always want to join             */
public class Futures {

    Futures() { }

    // maybe it is better to return an optional list? empty list is not the same as successful operation
    public static <T> List<T> ofAll(List<CompletableFuture<T>> possibleFutures, Function<Throwable, RuntimeException> exceptionMapper) {
        List<T> results = new ArrayList<>();

        boolean interrupted = false;
        Throwable throwable = null;
        for (CompletableFuture<T> possibleFuture : possibleFutures) {
            try {
                if (interrupted || throwable != null) possibleFuture.cancel(true);
                T concreteFuture = possibleFuture.get();
                results.add(concreteFuture);
            } catch (InterruptedException e) {
                interrupted = true;
            } catch (ExecutionException e) {
                throwable = e;
            }
        }

        if (throwable != null) throw exceptionMapper.apply(throwable);
        if (interrupted) return new ArrayList<>();

        return results;
    }

    public static <T> List<T> ofAll(List<CompletableFuture<T>> possibleFutures) {
        List<T> results = new ArrayList<>();

        boolean interrupted = false;
        for (CompletableFuture<T> possibleFuture : possibleFutures) {
            try {
                if (interrupted) possibleFuture.cancel(true);
                T concreteFuture = possibleFuture.get();
                results.add(concreteFuture);
            } catch (Throwable e) {
                interrupted = true;
            }
        }

        if (interrupted) return new ArrayList<>();

        return results;
    }

    public static <T> List<T> ofAllSuccessful(List<CompletableFuture<T>> possibleFutures) {
        List<T> results = new ArrayList<>();

        for (CompletableFuture<T> possibleFuture : possibleFutures) {
            try {
                T concreteFuture = possibleFuture.get();
                results.add(concreteFuture);
            }
            catch (InterruptedException | ExecutionException ignored) { }
        }

        return results;
    }
}
