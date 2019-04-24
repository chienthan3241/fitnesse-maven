/*
 * Copyright (c) arvato infoscore group: InFoScore Software Service GmbH
 *                                       Rheinstrasse 99
 *                                       76532 Baden-Baden, Germany
 * * All rights reserved. arvato infoscore PROPRIETARY / CONFIDENTIAL. *
 */
package com.arvarto.fixture;

import com.arvarto.fitnesseExp.Product;
import com.arvarto.fitnesseExp.Shop;

import fit.RowFixture;

/**
 * @author $Author$
 * @version $Revision$
 */
public class RowFixtureTest extends RowFixture {

   /*
    * (non-Javadoc) {@inheritDoc}
    * @see fit.RowFixture#query()
    */
   @Override
   public Object[] query() throws Exception {
      return Shop.products.toArray();
   }

   /*
    * (non-Javadoc) {@inheritDoc}
    * @see fit.RowFixture#getTargetClass()
    */
   @Override
   public Class<?> getTargetClass() {
      return Product.class;
   }

}
