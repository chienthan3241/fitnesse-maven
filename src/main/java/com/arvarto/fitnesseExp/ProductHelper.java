/*
 * Copyright (c) arvato infoscore group: InFoScore Software Service GmbH
 *                                       Rheinstrasse 99
 *                                       76532 Baden-Baden, Germany
 * * All rights reserved. arvato infoscore PROPRIETARY / CONFIDENTIAL. *
 */
package com.arvarto.fitnesseExp;

import java.util.List;

/**
 * @author $Author$
 * @version $Revision$
 */
public class ProductHelper {
   public double getNetto(List<Product> products) {
      Double result = 0.0;
      for (Product p : products) {
         result += p.getPreis();
      }

      return result;
   }

   public double getBrutto(List<Product> products) {
      Double result = 0.0;
      for (Product p : products) {
         result += p.getPreis() + p.getPreis() * getTaxPercent(p);
      }

      return result;
   }

   public double getTaxPercent(Product p) {
      if (TaxTable.NormalTaxTable.get(p.getCode()) != null) {
         return TaxTable.NormalTaxTable.get(p.getCode());
      }
      if (TaxTable.SonderTaxTable.get(p.getCode()) != null) {
         return TaxTable.SonderTaxTable.get(p.getCode());
      }
      return 0.0;
   }

   public double getTotalTax(List<Product> ps) {
      Double result = 0.0;
      for (Product p : ps) {
         result += p.getPreis() * getTaxPercent(p);
      }
      return result;
   }
}
