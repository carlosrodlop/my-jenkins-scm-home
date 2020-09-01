# REST

## Alias (incluying auth)

Ref: https://docs.cloudbees.com/docs/admin-resources/latest/cli-guide/config-alias

```sh
alias jenkins-rest-get='/path/to/jenkins-rest-get.sh'
alias jenkins-rest-post='/path/to/jenkins-rest-post.sh'
```

## Depth control

Control de mount of data with `tree` and `depth`

Ref: https://www.jenkins.io/doc/book/using/remote-access-api/#RemoteaccessAPI-Depthcontrol

## Crumb

Call to REST API including the .crumb in the same call

```sh
curl --user $USER:$APITOKEN -H $(curl --user $USER:$APITOKEN [-H "CRUB"] $SERVER/crumbIssuer/api/xml?xpath=concat\(//crumbRequestField,%22:%22,//crumb\))  $SERVER/job/hello-world-flow/build?token=codebase&cause=push
```

## RBAC

### List groups

```sh
$ jenkins-rest-get groups/api/json?depth=1&tree=groups[name]
{
_class: "nectar.plugins.rbac.groups.RootProxyGroupContainer",
groups: [
{
name: "administrators"
},
{
name: "users"
},
{
name: "viewers"
},
...
{
name: "fbelzunc-viewer"
}
]
}
```

### Create groups

```sh
$ jenkins-rest-post "groups/createGroup/api/json?name=developers
```
