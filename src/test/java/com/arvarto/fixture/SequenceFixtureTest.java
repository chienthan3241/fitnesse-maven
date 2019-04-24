/*
 * Copyright (c) arvato infoscore group: InFoScore Software Service GmbH
 *                                       Rheinstrasse 99
 *                                       76532 Baden-Baden, Germany
 * * All rights reserved. arvato infoscore PROPRIETARY / CONFIDENTIAL. *
 */
package com.arvarto.fixture;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.arvarto.fitnesseExp.Product;
import com.arvarto.fitnesseExp.ProductHelper;
import com.arvarto.fitnesseExp.Shop;
import com.arvarto.fitnesseExp.TaxTable;

import fitlibrary.SequenceFixture;

/**
 * @author $Author$
 * @version $Revision$
 */
public class SequenceFixtureTest extends SequenceFixture {
   public SequenceFixtureTest() {
      Shop.clearProduct();
   }

   public void addNormalProductWithPreis(Double preis) {
      Random r = new Random();
      List<?> normalTaxCodeList = TaxTable.NormalTaxTable.keySet().stream().collect(Collectors.toList());
      Shop.addProduct(new Product((String) normalTaxCodeList.get(r.nextInt(normalTaxCodeList.size())), preis));
   }

   public void addSonderProductWithPreis(Double preis) {
      Random r = new Random();
      List<?> sonderTaxCodeList = TaxTable.SonderTaxTable.keySet().stream().collect(Collectors.toList());
      Shop.addProduct(new Product((String) sonderTaxCodeList.get(r.nextInt(sonderTaxCodeList.size())), preis));
   }

   public void addNoTaxProductWithPreis(Double preis) {
      Shop.addProduct(new Product(preis));
   }

   public void clearProduct() {
      Shop.clearProduct();
   }

   public Double getNetto() {
      ProductHelper h = new ProductHelper();
      return h.getNetto(Shop.products);
   }

   public Double getBrutto() {
      ProductHelper h = new ProductHelper();
      return h.getBrutto(Shop.products);
   }
}
