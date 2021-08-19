package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario3 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Usuario usuario = em.find(Usuario.class, 8L);
		em.detach(usuario); // funcao que tira o objeto do estado gerenciado
		
		usuario.setNome("Leonardo");
		usuario.setEmail("leonardo@lanche.com.br");
		
		em. merge(usuario);
		 
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}	
}
