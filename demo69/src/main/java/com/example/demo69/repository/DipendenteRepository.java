package com.example.demo69.repository;

//MANCANO GLI IMPORT

public interface DipendenteRepository extends JpaRepository<Dipendente, long> { //jparepository ad metodi di base corrispondentialle CRUD
    //Qui si possono mettere le query
    //SAVE per inserimento e update
    //FIND o FINDALL e vari FIND per ricerca e lettura
    //DELETE per le varie cancellazioni

    //@Query è un annotation di Spring
    @Query("SELECT d FROM Dipendente d WHERE d.id = ?1") //?1 significa "passami questo parametro
    Optional<Dipendente> findByID(long id);

    //@NativeQuery è una variante per un altro tipo di query, quella usata prima è in linguaggio Java
    @Query("SELECT d FROM Dipendente d")
    List<Dipendente> findAll();

    //find by nome
    @Query("SELECT d FROM Dipendente d WHERE d.cf LIKE %?1") //Qui si può aggiungere il modulo e fare il giochetto "Inizia con"/"Finisce con"
    Lista<Dipendente> findAllByCf(String cf);

    //Diferenza tra query e named query è che le named sono "predefinite" che vengono inserite direttamente uslle entity


    //Vedere su YT nel caso l'autogenerazione di Query con JPAbuddy che autocompila la @Query e autospawna la List risultante (ma che può anche essere un Set se non avremo dati doppiati)
}
