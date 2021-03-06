/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.ap.test.selection.qualifier.errors;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Qualifier;

@Mapper
public interface ErroneousMessageByNamedMapper {

    @Mapping(target = "nested", source = "value", qualifiedByName = "SelectMe")
    Target map(Source source);

    default Nested map(String in) {
        return null;
    }

    // CHECKSTYLE:OFF
    class Source {
        public String value;
    }

    class Target {
        public Nested nested;
    }

    class Nested {
        public String value;
    }
    // CHECKSTYLE ON

    @Qualifier
    @java.lang.annotation.Target(ElementType.METHOD)
    @Retention(RetentionPolicy.CLASS)
    public @interface SelectMe {
    }
}
