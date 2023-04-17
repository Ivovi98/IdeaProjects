/*
Per un social network, implementare le classi SocialUser e Post. Un utente è dotato di un nome
e può creare dei post tramite il metodo newPost. Il contenuto di un post è una stringa, che
può contenere nomi di utenti, preceduti dal simbolo “@”. Il metodo getTagged della classe Post
restituisce l’insieme degli utenti il cui nome compare in quel post, mentre il metodo getAuthor
restituisce l’autore del post.
L’implementazione deve rispettare il seguente esempio d’uso:
 */
package org.social;

import java.util.Set;

public class SocialMain {
    public static void main(String[] args) {
        User adriana = new User("Adriana"),
        barbara = new User("Barbara");
        User.Post p = adriana.newPost("Ecco una foto con @Barbara e @Carla.");
    Set<User> tagged = p.getTagged();
    System.out.println(tagged);
    System.out.println(tagged. iterator () .next() == barbara);
    System.out.println(p.getAuthor());
    }
}
