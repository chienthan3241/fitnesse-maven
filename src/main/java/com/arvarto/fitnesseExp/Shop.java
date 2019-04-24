/*
 * Copyright (c) arvato infoscore group: InFoScore Software Service GmbH
 *                                       Rheinstrasse 99
 *                                       76532 Baden-Baden, Germany
 * * All rights reserved. arvato infoscore PROPRIETARY / CONFIDENTIAL. *
 */
package com.arvarto.fitnesseExp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author $Author$
 * @version $Revision$
 */
public class Shop {
   public static List<Product> products = new ArrayList<Product>();

   public static void addProduct(Product p) {
      products.add(p);
   }

   public static void clearProduct() {
      products.clear();
   }

   public static Product getByName(String name) {
      for (Product p : products) {
         if (p.getName().equals(name)) {
            return p;
         }
      }
      return null;
   }
}
