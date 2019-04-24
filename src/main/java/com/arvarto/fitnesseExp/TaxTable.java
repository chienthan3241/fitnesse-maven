/*
 * Copyright (c) arvato infoscore group: InFoScore Software Service GmbH
 *                                       Rheinstrasse 99
 *                                       76532 Baden-Baden, Germany
 * * All rights reserved. arvato infoscore PROPRIETARY / CONFIDENTIAL. *
 */
package com.arvarto.fitnesseExp;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

/**
 * @author $Author$
 * @version $Revision$
 */
public class TaxTable {
   public static Map<String, Double> NormalTaxTable = ImmutableMap.of( //
            "B978-0201616224", 0.19, //
            "ERDR-GX330", 0.19, //
            "B978-0321146533", 0.19 //
            );
   public static Map<String, Double> SonderTaxTable = ImmutableMap.of( //
            "SONDER_TAX1", 0.1 //
            );

   public static void addTax(String code, Double tax) {
      if (tax == 0.19) {
         NormalTaxTable.put(code, tax);
      } else {
         SonderTaxTable.put(code, tax);
      }
   }
}
