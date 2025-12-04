package br.com.neresfelip.gfxconsultoria.data.remote;

public interface RepositoryCallback<T> {
    void onSuccess(T data);
    void onError(Throwable t);
}
