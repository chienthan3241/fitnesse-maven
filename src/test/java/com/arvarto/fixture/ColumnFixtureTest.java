/*
 * Copyright (c) arvato infoscore group: InFoScore Software Service GmbH
 *                                       Rheinstrasse 99
 *                                       76532 Baden-Baden, Germany
 * * All rights reserved. arvato infoscore PROPRIETARY / CONFIDENTIAL. *
 */
package com.arvarto.fixture;

import com.arvarto.fitnesseExp.Product;
import com.arvarto.fitnesseExp.ProductHelper;

import fit.ColumnFixture;

/**
 * @author $Author$
 * @version $Revision$
 */
public class ColumnFixtureTest extends ColumnFixture {
   private String code;
   private Double preis;

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

}
