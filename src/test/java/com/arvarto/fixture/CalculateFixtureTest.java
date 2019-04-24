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

import fitlibrary.CalculateFixture;

/**
 * @author $Author$
 * @version $Revision$
 */
public class CalculateFixtureTest extends CalculateFixture {
   List<Product> ps = new ArrayList<Product>();

   public Double getTaxCodePreis(String code, Double preis) {
      ps.clear();
      ps.add(new Product(code, preis));
      ProductHelper h = new ProductHelper();
      return h.getBrutto(ps);
   }
}
