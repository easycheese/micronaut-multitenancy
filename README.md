# Micronaut Multitenancy

[![Maven Central](https://img.shields.io/maven-central/v/io.micronaut.multitenancy/micronaut-multitenancy.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22io.micronaut.multitenancy%22%20AND%20a:%22micronaut-multitenancy%22)
[![Build Status](https://github.com/micronaut-projects/micronaut-multitenancy/workflows/Java%20CI/badge.svg)](https://github.com/micronaut-projects/micronaut-multitenancy/actions)

Multi-Tenancy, as it relates to software development, is when a single instance of an application is used to service multiple clients (tenants) in a way that each tenant’s data is isolated from the other.

Micronaut Multitenancy helps to add multi-tenancy capabilities to your application. 

## Documentation

See the [Documentation](https://micronaut-projects.github.io/micronaut-multitenancy/latest/guide/) for more information. 

See the [Snapshot Documentation](https://micronaut-projects.github.io/micronaut-multitenancy/snapshot/guide/) for the current development docs.

## Examples

Examples can be found in the [examples](https://github.com/micronaut-projects/micronaut-multitenancy/tree/master/examples) directory.

## Snapshots and Releases

Snaphots are automatically published to [JFrog OSS](https://oss.jfrog.org/artifactory/oss-snapshot-local/) using [Github Actions](https://github.com/micronaut-projects/micronaut-multitenancy/actions).

See the documentation in the [Micronaut Docs](https://docs.micronaut.io/latest/guide/index.html#usingsnapshots) for how to configure your build to use snapshots.

Releases are published to JCenter and Maven Central via [Github Actions](https://github.com/micronaut-projects/micronaut-multitenancy/actions).

Releases are completely automated. To perform a release use the following steps:

* [Publish the draft release](https://github.com/micronaut-projects/micronaut-multitenancy/releases). There should be already a draft release created, edit and publish it. The Git Tag should start with `v`. For example `v1.0.0`.
* [Monitor the Workflow](https://github.com/micronaut-projects/micronaut-multitenancy/actions?query=workflow%3ARelease) to check it passed successfully.
* Celebrate!
