/*
 * Copyright 2017-2020 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.multitenancy.tenantresolver;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.multitenancy.MultitenancyConfiguration;
import io.micronaut.multitenancy.exceptions.TenantNotFoundException;

import java.io.Serializable;

/**
 * An interface for applications that implement Multi Tenancy to implement in order to resolve the current identifier.
 *
 * @author Sergio del Amo
 * @since 1.0
 */
@FunctionalInterface
public interface TenantResolver {

    String PREFIX = MultitenancyConfiguration.PREFIX + ".tenantresolver";

    /**
     * The name of the default tenant.
     */
    String DEFAULT = "DEFAULT";

    /**
     * Constant for a mapping to all tenants.
     */
    String ALL = "DEFAULT";

    /**
     * <p>Resolves the current tenant identifier.
     *
     * <p>In a Multi Tenant setup where a single database is being used amongst multiple tenants this would be the object that is used as the tenantId property for each domain class.</p>
     *
     * @return The tenant identifier
     * @throws TenantNotFoundException if tenant not found
     */
    @NonNull
    Serializable resolveTenantIdentifier() throws TenantNotFoundException;
}
