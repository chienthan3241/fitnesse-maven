/*
 * Copyright (c) arvato infoscore group: InFoScore Software Service GmbH
 *                                       Rheinstrasse 99
 *                                       76532 Baden-Baden, Germany
 * * All rights reserved. arvato infoscore PROPRIETARY / CONFIDENTIAL. *
 */
package com.arvarto.fixture;

import com.arvarto.fitnesseExp.Product;
import com.arvarto.fitnesseExp.Shop;

import fitlibrary.SubsetFixture;

/**
 * @author $Author$
 * @version $Revision$
 */
public class SubsetFixtureTest extends SubsetFixture {
   public SubsetFixtureTest() {
      Shop.clearProduct();
      Shop.addProduct(new Product("product1", "wrong_code", 100.0));
      Shop.addProduct(new Product("product2", "ERDR-GX330", 200.0));
      this.setActualCollection(Shop.products);
   }
}
