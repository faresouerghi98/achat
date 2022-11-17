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

import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class StockServiceTest {
    @Autowired
    IStockService ss;
    StockRepository stockRepository = Mockito.mock(StockRepository.class);

    Stock s1 = new Stock("stock1", 5, 3);
    Stock s2 = new Stock("stock2", 5, 3);
    List<Stock> stocks = new ArrayList<Stock>() ;
   
   
    @Test
    @Order(1)
    public void testRetrieveAllStocks() {
        stocks.add(s1);
        stocks.add(s2);
        Mockito.when(stockRepository.findAll()).thenReturn(stocks);
        List<Stock> listStocks = stockRepository.findAll();
        Assertions.assertEquals(stocks.size(), listStocks.size());
    }
}
