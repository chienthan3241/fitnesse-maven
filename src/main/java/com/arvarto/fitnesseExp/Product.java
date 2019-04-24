/*
 * Copyright (c) arvato infoscore group: InFoScore Software Service GmbH
 *                                       Rheinstrasse 99
 *                                       76532 Baden-Baden, Germany
 * * All rights reserved. arvato infoscore PROPRIETARY / CONFIDENTIAL. *
 */
package com.arvarto.fitnesseExp;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author $Author$
 * @version $Revision$
 */
public class Product {
   private String name, code;
   private Double preis;

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getCode() {
      return code;
   }

   public void setCode(String code) {
      this.code = code;
   }

   public Double getPreis() {
      return preis;
   }

   public void setPreis(Double preis) {
      this.preis = preis;
   }

   public Product(Double preis) {
      this(RandomStringUtils.random(10, true, false), RandomStringUtils.random(10, true, false), preis);
   }

   public Product(String code, Double preis) {
      this(RandomStringUtils.random(10, true, false), code, preis);
   }

   public Product(String name, String code, Double preis) {
      super();
      this.name = name;
      this.code = code;
      this.preis = preis;
   }

}
