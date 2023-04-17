/*
Per un social network, implementare le classi SocialUser e Post. Un utente è dotato di un nome
e può creare dei post tramite il metodo newPost. Il contenuto di un post è una stringa, che
può contenere nomi di utenti, preceduti dal simbolo “@”. Il metodo getTagged della classe Post
restituisce l’insieme degli utenti il cui nome compare in quel post, mentre il metodo getAuthor
restituisce l’autore del post.
L’implementazione deve rispettare il seguente esempio d’uso:
 */
package org.social;

import java.util.*;

public class User {
    private String nomeUser;




    public User(String nomeUser) {
        this.nomeUser = nomeUser;
    }
    public String getNomeUser() {
        return nomeUser;
    }
    public void setNomeUser(String nomeUser) {
        this.nomeUser = nomeUser;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return nomeUser.equals(user.nomeUser);
    }
    @Override
    public int hashCode() {
        return Objects.hash(nomeUser);
    }



    //METODI
    public Post newPost(String s) {
        return new Post(s);
    }

    public class Post {
        private Set<User> utentiTaggati = new HashSet<>();
        private String contenuto;

        private Post(String s) { //accesso al post solo tramite user (autore), encapsulation, costruttore private
            this.contenuto = s;
        }
        public Set<User> getUtentiTaggati() {
            return utentiTaggati;
        }
        public void setUtentiTaggati(Set<User> utentiTaggati) {
            this.utentiTaggati = utentiTaggati;
        }

        //METODI
        public Set<User> getTagged() {
            String utenteSenzaChiocciola = "";
            StringTokenizer st = new StringTokenizer(contenuto);
            st.nextToken("@"); //Restituisce la stringa prima della @ ( ma a noi interessa quello che viene dopo fino allo " "
            String utenteTaggato = st.nextToken(" "); //qui il token si ferma appena vede uno spazio
            for (int i = 1; i < utenteTaggato.length(); i++){ //La chiocciola si trova a int i = 0
                utenteSenzaChiocciola += utenteTaggato.charAt(i); //assegno a utenteSenzaChiocciola la String di utenteTaggato da i
            }
            User u = new User(utenteSenzaChiocciola); //Devo creare un utente perché devo aggiungerlo a un set
            utentiTaggati.add(u);
            return utentiTaggati; //restituisco il set
        }

        public String getAuthor() {
            return User.this.getNomeUser();

        }
    }
}
