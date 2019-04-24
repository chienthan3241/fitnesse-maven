/*
 * Copyright (c) arvato infoscore group: InFoScore Software Service GmbH
 *                                       Rheinstrasse 99
 *                                       76532 Baden-Baden, Germany
 * * All rights reserved. arvato infoscore PROPRIETARY / CONFIDENTIAL. *
 */
package com.arvarto.fixture;

import java.util.ArrayList;
import java.util.List;

import com.arvarto.fitnesseExp.Product;
import com.arvarto.fitnesseExp.ProductHelper;

import fitnesse.fixtures.TableFixture;

/**
 * @author $Author$
 * @version $Revision$
 */
public class TableFixtureTest extends TableFixture {

   /*
    * (non-Javadoc) {@inheritDoc}
    * @see fitnesse.fixtures.TableFixture#doStaticTable(int)
    */
   @Override
   protected void doStaticTable(int rows) {
      List<Product> ps = new ArrayList<Product>();
      ProductHelper h = new ProductHelper();
      double totaltax = 0.0;
      double totalBruttoPreis = 0.0;
      double totalNettoPreis = 0.0;

      for (int row = 1; row < rows - 3; row++) {
         ps.add(new Product(getText(row, 0), getText(row, 1), Double.parseDouble(getText(row, 2))));
      }
      totaltax = Math.round(h.getTotalTax(ps) * 100.0) / 100.0;
      totalNettoPreis = Math.round(h.getNetto(ps) * 100.0) / 100.0;
      totalBruttoPreis = Math.round(h.getBrutto(ps) * 100.0) / 100.0;
      double taxintable = Double.parseDouble(getText(rows - 2, 2));
      double totalNettointable = Double.parseDouble(getText(rows - 3, 2));
      double totalBruttointable = Double.parseDouble(getText(rows - 1, 2));
      {
         if (totalNettointable == totalNettoPreis) {
            right(rows - 3, 2);
         } else {
            wrong(rows - 3, 2, String.valueOf(totalNettoPreis));
         }
         if (taxintable == totaltax) {
            right(rows - 2, 2);
         } else {
            wrong(rows - 2, 2, String.valueOf(totaltax));
         }
         if (totalBruttointable == totalBruttoPreis) {
            right(rows - 1, 2);
         } else {
            wrong(rows - 1, 2, String.valueOf(totalBruttoPreis));
         }
      }
   }
}
