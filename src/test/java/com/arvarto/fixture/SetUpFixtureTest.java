/*
 * Copyright (c) arvato infoscore group: InFoScore Software Service GmbH
 *                                       Rheinstrasse 99
 *                                       76532 Baden-Baden, Germany
 * * All rights reserved. arvato infoscore PROPRIETARY / CONFIDENTIAL. *
 */
package com.arvarto.fixture;

import com.arvarto.fitnesseExp.Product;
import com.arvarto.fitnesseExp.Shop;

import fitlibrary.SetUpFixture;

/**
 * @author $Author$
 * @version $Revision$
 */
public class SetUpFixtureTest extends SetUpFixture {
   public SetUpFixtureTest() {
      Shop.clearProduct();
   }

   public void nameCodePreis(String name, String code, Double preis) {
      Shop.addProduct(new Product(name, code, preis));
   }
}
