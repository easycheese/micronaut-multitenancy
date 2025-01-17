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
import io.micronaut.context.annotation.Requires;
import io.micronaut.core.util.StringUtils;
import io.micronaut.http.HttpAttributes;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.context.ServerRequestContext;
import io.micronaut.multitenancy.exceptions.TenantNotFoundException;

import jakarta.inject.Singleton;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.security.Principal;
import java.util.Optional;

/**
 * A tenant resolver that resolves the tenant from the authenticated principal.
 *
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Singleton
@Requires(property = PrincipalTenantResolverConfigurationProperties.PREFIX + ".enabled", value = StringUtils.TRUE, defaultValue = StringUtils.FALSE)
public class PrincipalTenantResolver implements TenantResolver, HttpRequestTenantResolver {

    @NonNull
    @Override
    public Serializable resolveTenantIdentifier() {
        Optional<HttpRequest<Object>> current = ServerRequestContext.currentRequest();
        return current.map(this::resolveTenantIdentifier).orElseThrow(() -> new TenantNotFoundException("Tenant could not be resolved outside a web request"));
    }

    @Override
    @NonNull
    public Serializable resolveTenantIdentifier(@NonNull @NotNull HttpRequest<?> request) throws TenantNotFoundException {
        return request.getUserPrincipal().map(Principal::getName)
                .orElseThrow(() ->
                        new TenantNotFoundException("Tenant could not be resolved because " + HttpAttributes.PRINCIPAL + " attribute was not found")
                );
    }
}
