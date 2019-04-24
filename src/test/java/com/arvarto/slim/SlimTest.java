/*
 * Copyright (c) arvato infoscore group: InFoScore Software Service GmbH
 *                                       Rheinstrasse 99
 *                                       76532 Baden-Baden, Germany
 * * All rights reserved. arvato infoscore PROPRIETARY / CONFIDENTIAL. *
 */
package com.arvarto.slim;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.arvarto.fitnesseExp.Product;
import com.arvarto.fitnesseExp.ProductHelper;
import com.arvarto.fitnesseExp.TaxTable;

/**
 * @author $Author$
 * @version $Revision$
 */
public class SlimTest {
   private String code;
   private Double preis;
   private List<Product> ps = new ArrayList<Product>();
   private static Map<String, Double> taxTable = new HashMap<String, Double>();

   static {
      // TaxTable.NormalTaxTable.forEach((k, v) -> {
      // taxTable.put(k, v);
      // });
      // TaxTable.SonderTaxTable.forEach((k, v) -> {
      // taxTable.put(k, v);
      // });
      taxTable.putAll(TaxTable.NormalTaxTable);
      taxTable.putAll(TaxTable.SonderTaxTable);
   }

   public void setCode(String code) {
      this.code = code;
   }

   public void setPreis(Double preis) {
      this.preis = preis;
   }

   public Double getTax() {
      Product p = new Product(code, preis);
      ProductHelper h = new ProductHelper();
      return h.getTaxPercent(p);
   }

   public double getPreisWithTaxOfProduct() {
      ps.clear();
      ProductHelper h = new ProductHelper();
      ps.add(new Product(code, preis));
      return h.getBrutto(ps);
   }

   public void set(String code, double preis) {
      ps.add(new Product(code, preis));
   }

   public double get(String requestedValue) {
      ProductHelper h = new ProductHelper();
      if ("total preis without tax".equals(requestedValue)) {
         return h.getNetto(ps);
      } else if ("total preis with tax".equals(requestedValue)) {
         return h.getBrutto(ps);
      } else if ("clear product list".equals(requestedValue)) {
         ps.clear();
      }
      return 0.0;
   }

   public List<List<List<String>>> query() {
      return asList(
      // table level
               asList( // row level
               asList("product name", "product 1"), // cell column name, value
                        asList("product code", "B978-0201616224"), //
                        asList("tax", "0.19"), //
                        asList("amount", "10") //
               ), //
               asList(//
               asList("product name", "product 2"), // cell column name, value
                        asList("product code", "ERDR-GX330"), //
                        asList("tax", "0.19"), //
                        asList("amount", "20") //
               ),//
               asList(//
               asList("product name", "product 3"), // cell column name, value
                        asList("product code", "B978-0321146533"), //
                        asList("tax", "0.19"), //
                        asList("amount", "30") //
               ),//
               asList(//
               asList("product name", "product 4"), // cell column name, value
                        asList("product code", "SONDER_TAX1"), //
                        asList("tax", "0.1"), //
                        asList("amount", "100") //
               )//
      );
   }
}
