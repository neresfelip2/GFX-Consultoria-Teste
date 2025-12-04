package br.com.neresfelip.gfxconsultoria.data.repository.callback;

public interface RepositoryCallback<T> {
    void onSuccess(T data);
    void onError(Throwable t);
}
