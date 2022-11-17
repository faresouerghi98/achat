package tn.esprit.rh.achat.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class ProduitServiceTest {
    @Autowired
    
    ProduitRepository produitRepository = Mockito.mock(ProduitRepository.class);

    Produit p1 = new Produit("produit1");
    Produit p2 = new Produit("produit2");
    List<Produit> produits = new ArrayList<Produit>() ;
   
   
    @Test
    @Order(1)
    public void testRetrieveAllProduits() {
        produits.add(p1);
        produits.add(p2);
        Mockito.when(produitRepository.findAll()).thenReturn(produits);
        List<Produit> listProduits = produitRepository.findAll();
        Assertions.assertEquals(produits.size(), listProduits.size());
    }
}
