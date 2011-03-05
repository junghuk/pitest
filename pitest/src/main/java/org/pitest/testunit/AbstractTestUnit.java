/*
 * Copyright 2010 Henry Coles
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and limitations under the License. 
 */
package org.pitest.testunit;

import java.util.Collections;
import java.util.Iterator;

import org.pitest.Description;
import org.pitest.extension.ResultCollector;
import org.pitest.extension.TestFilter;
import org.pitest.extension.TestUnit;
import org.pitest.functional.Option;

/**
 * @author henry
 * 
 */
public abstract class AbstractTestUnit implements TestUnit {

  private final Description description;

  public AbstractTestUnit(final Description description) {
    this.description = description;
  }

  public Iterator<TestUnit> iterator() {
    return Collections.<TestUnit> emptyList().iterator();
  }

  public abstract void execute(final ClassLoader loader,
      final ResultCollector rc);

  public final Description getDescription() {
    return this.description;
  }

  public Option<TestUnit> filter(final TestFilter filter) {
    if (filter.include(this)) {
      return Option.<TestUnit> some(this);
    } else {
      return Option.none();
    }

  }

}