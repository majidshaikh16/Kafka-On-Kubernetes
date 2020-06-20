## Get Started
```link
https://cloud.google.com/kubernetes-engine/docs/quickstart
```
* When Setting up the google cloud account for kubernetes cluster
there are some mandatory step need to be set in order to use the gcloud console and its services same like we use in our develop env

- gcloud config set project simple-k8s-255511
- gcloud config set compute/zone asia-south1-a
- gcloud container clusters get-credentials simple-cluster
- kubectl create secret generic password --from-literal PGPASSWORD=root # setup passwords if any
- installing helm # this is a package manager for k8s in short cli which behind the scene git the tiller(Tiller is a pod) for installing the 3rd party dependency
- https://helm.sh/docs/using_helm/#installing-helm # search for From Script and install the helm from the given command
- RBAC(Role based access and control)
- RBAC limits the access for who can access what and modify certain sets of access given
- Google cloud by default enables RBAC
- We would need to give Tiller the access to modify the setting inside of our cluster
- Create a new service account called tiller in the kube system namespace(kubectl get namespaces) hit the bellow command in gconsole

- kubectl create serviceaccount --namespace kube-system tiller

- Now we need to set the role binding that is the clusterrolebinding with the role 'cluster-admin' and assign it to the above created service account tiller
- hit the below command in gconsole

- kubectl create clusterrolebinding tiller-cluster-rule --clusterrole=cluster-admin --serviceaccount=kube-system:tiller

- initialize helm now so we can start installing nginx-ingress

- helm init --service-account tiller --upgrade

- now we are good to go and install the nginx-ingress for our kubernetes cluster
- hit the below command in gconsole

- helm install stable/nginx-ingress --name my-nginx --set rbac.create=true
