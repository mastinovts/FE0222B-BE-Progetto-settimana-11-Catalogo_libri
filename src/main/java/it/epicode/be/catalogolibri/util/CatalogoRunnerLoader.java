package it.epicode.be.catalogolibri.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.epicode.be.catalogolibri.model.Autore;
import it.epicode.be.catalogolibri.model.Categoria;
import it.epicode.be.catalogolibri.model.Libro;
import it.epicode.be.catalogolibri.repository.AutoreRepository;
import it.epicode.be.catalogolibri.repository.CategoriaRepository;
import it.epicode.be.catalogolibri.repository.LibroRepository;

@Component
public class CatalogoRunnerLoader implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepo;

	@Autowired
	private AutoreRepository autoreRepo;

	@Autowired
	private LibroRepository libroRepo;

	@Override
	public void run(String... args) throws Exception {

		List<Categoria> categorie = initCategorie();
		Categoria drammatico = categorie.get(0);
		Categoria fantasy = categorie.get(1);
		Categoria sportivo = categorie.get(2);
		categoriaRepo.save(drammatico);
		categoriaRepo.save(fantasy);
		categoriaRepo.save(sportivo);

		List<Categoria> listaCategoria1 = new ArrayList<>();
		List<Categoria> listaCategoria2 = new ArrayList<>();
		List<Categoria> listaCategoria3 = new ArrayList<>();
		listaCategoria1.add(drammatico);
		listaCategoria2.add(fantasy);
		listaCategoria3.add(sportivo);

		List<Autore> autori = initAutori();
		Autore a1 = autori.get(0);
		Autore a2 = autori.get(1);
		Autore a3 = autori.get(2);
		autoreRepo.save(a1);
		autoreRepo.save(a2);
		autoreRepo.save(a3);

		List<Autore> listaAutori1 = new ArrayList<>();
		List<Autore> listaAutori2 = new ArrayList<>();
		List<Autore> listaAutori3 = new ArrayList<>();
		listaAutori1.add(a1);
		listaAutori2.add(a2);
		listaAutori3.add(a3);

		List<Libro> libri = initLibri();

		Libro listaLibri1 = libri.get(0);
		Libro listaLibri2 = libri.get(1);
		Libro listaLibri3 = libri.get(2);
		listaLibri1.setAutori(listaAutori1);
		listaLibri1.setCategorie(listaCategoria1);
		listaLibri2.setAutori(listaAutori2);
		listaLibri2.setCategorie(listaCategoria2);
		listaLibri3.setAutori(listaAutori3);
		listaLibri3.setCategorie(listaCategoria3);
		libroRepo.save(listaLibri1);
		libroRepo.save(listaLibri2);
		libroRepo.save(listaLibri3);

	}

	private List<Libro> initLibri() {
		List<Libro> listaLibri = new ArrayList<>();

		Libro libro1 = new Libro();
		Libro libro2 = new Libro();
		Libro libro3 = new Libro();
		libro1.setTitolo("Dall'aldilà");
		libro1.setAnnoPubblicazione(1989);
		libro1.setPrezzo(19.50);
		libro2.setTitolo("Dragon Ball");
		libro2.setAnnoPubblicazione(1990);
		libro2.setPrezzo(29.90);
		libro3.setTitolo("Punizioni");
		libro3.setAnnoPubblicazione(1989);
		libro3.setPrezzo(35.00);

		listaLibri.add(libro1);
		listaLibri.add(libro2);
		listaLibri.add(libro3);

		return listaLibri;
	}

	private List<Categoria> initCategorie() {
		List<Categoria> categorie = new ArrayList<>();
		Categoria drammatico = new Categoria();
		Categoria fantasy = new Categoria();
		Categoria sportivo = new Categoria();
		drammatico.setNome("Drammatico");
		fantasy.setNome("Fantasy");
		sportivo.setNome("Sportivo");

		categorie.add(drammatico);
		categorie.add(fantasy);
		categorie.add(sportivo);

		return categorie;
	}

	private List<Autore> initAutori() {
		List<Autore> listaAutori = new ArrayList<>();

		Autore autore1 = new Autore();
		Autore autore2 = new Autore();
		Autore autore3 = new Autore();
		autore1.setNome("Francesco");
		autore1.setCognome("Franceschini");
		autore2.setNome("Rosario");
		autore2.setCognome("Buttolo");
		autore3.setNome("Paolo");
		autore3.setCognome("Rossi");

		listaAutori.add(autore1);
		listaAutori.add(autore2);
		listaAutori.add(autore3);

		return listaAutori;

	}

}
