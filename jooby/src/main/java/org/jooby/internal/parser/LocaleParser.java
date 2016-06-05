/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jooby.internal.parser;

import java.util.Locale;

import org.jooby.Parser;
import org.jooby.internal.LocaleUtils;

import com.google.inject.TypeLiteral;

public class LocaleParser implements Parser {

  @Override
  public Object parse(final TypeLiteral<?> type, final Parser.Context ctx) throws Throwable {
    if (Locale.class == type.getRawType()) {
      return ctx.param(values -> LocaleUtils.parse(values.get(0)))
          .body(body -> LocaleUtils.parseOne(body.text()));
    } else {
      return ctx.next();
    }
  }

  @Override
  public String toString() {
    return "Locale";
  }

}