package util;

public interface InterfaceDouble<T>{

    
    void addFirst(T elemente);                    // adicionar no inicio
    void addLast(T elemente);                     // adicionar no fim
    void addAfter(T elemente,T criterio);         // adicionar em qualquer canto seguindo um criterio
    
    T removeFirst();                              // remover inicio
    T removeLast();                               // remover fim
    T remove(T criterio);                         // remover em qualquer canto seguindo um criterio
   
    T search(T elemente);                         // buscar elemento seguindo um criterio
    
    void show();                                  // mostrar lista
    
    T peekFirst();                                // pegar elemento do inicio da lista
    T peekLast();                                // pegar elemento do fim da lista
}
