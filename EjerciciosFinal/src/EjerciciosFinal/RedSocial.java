package EjerciciosFinal;

import java.util.ArrayList;
import java.util.List;

class Usuario {
    private String nombre;
    private List<Usuario> amigos;
    private List<Publicacion> publicaciones;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.amigos = new ArrayList<>();
        this.publicaciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarAmigo(Usuario amigo) {
        if (!amigos.contains(amigo)) {
            amigos.add(amigo);
            amigo.amigos.add(this); // Agregar al amigo reciproco
            System.out.println(nombre + " y " + amigo.getNombre() + " ahora son amigos.");
        }
    }

    public void enviarSolicitudAmistad(Usuario amigo) {
        System.out.println(nombre + " ha enviado una solicitud de amistad a " + amigo.getNombre() + ".");
    }

    public void publicar(String contenido) {
        Publicacion publicacion = new Publicacion(this, contenido);
        publicaciones.add(publicacion);
        System.out.println(nombre + " ha publicado: " + contenido);
    }

    public void mostrarFeed() {
        System.out.println("Feed de noticias de " + nombre + ":");
        for (Publicacion publicacion : publicaciones) {
            System.out.println(publicacion);
        }
        for (Usuario amigo : amigos) {
            for (Publicacion publicacion : amigo.publicaciones) {
                System.out.println(amigo.getNombre() + " publicó: " + publicacion.getContenido());
            }
        }
    }

    public int obtenerCantidadAmigos() {
        return amigos.size();
    }

    public int obtenerCantidadMeGusta() {
        int likes = 0;
        for (Publicacion publicacion : publicaciones) {
            likes += publicacion.obtenerLikes();
        }
        return likes;
    }
}

class Publicacion {
    private Usuario autor;
    private String contenido;
    private int likes;

    public Publicacion(Usuario autor, String contenido) {
        this.autor = autor;
        this.contenido = contenido;
        this.likes = 0;
    }

    public void darMeGusta() {
        likes++;
    }

    public int obtenerLikes() {
        return likes;
    }

    public String getContenido() {
        return contenido;
    }

    @Override
    public String toString() {
        return autor.getNombre() + " publicó: " + contenido + " - " + likes + " Me gusta";
    }
}

public class RedSocial {
    public static void main(String[] args) {
        Usuario usuario1 = new Usuario("Usuario1");
        Usuario usuario2 = new Usuario("Usuario2");
        Usuario usuario3 = new Usuario("Usuario3");

        usuario1.enviarSolicitudAmistad(usuario2);
        usuario2.agregarAmigo(usuario1);
        usuario1.publicar("Hoy es un día soleado.");
        usuario2.publicar("¡Feliz cumpleaños!");
        usuario3.publicar("Nueva receta de cocina.");

        usuario1.mostrarFeed();
        usuario2.mostrarFeed();

        System.out.println("Cantidad de amigos de Usuario1: " + usuario1.obtenerCantidadAmigos());
        System.out.println("Cantidad de Me gusta en las publicaciones de Usuario2: " + usuario2.obtenerCantidadMeGusta());
    }
}
