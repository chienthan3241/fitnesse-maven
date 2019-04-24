/*
 * Copyright (c) arvato infoscore group: InFoScore Software Service GmbH
 *                                       Rheinstrasse 99
 *                                       76532 Baden-Baden, Germany
 * * All rights reserved. arvato infoscore PROPRIETARY / CONFIDENTIAL. *
 */
package com.arvarto.fixture;

import com.arvarto.fitnesseExp.TaxTable;

import fitlibrary.ConstraintFixture;

/**
 * @author $Author$
 * @version $Revision$
 */
public class ConstraintFixtureTest extends ConstraintFixture {
   public boolean normalTaxCodeTaxValue(String normalTaxCode, double taxValue) {
      return TaxTable.NormalTaxTable.containsKey(normalTaxCode)
             && TaxTable.NormalTaxTable.get(normalTaxCode) == taxValue;
   }
}
