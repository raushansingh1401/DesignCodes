#include<bits/stdc++.h>
using namespace std;

class Singleton{
private :
    static Singleton* instance;
    Singleton(){
        cout << "Singleton constructor called" << endl;
    }

    ~Singleton(){
        cout << "Singleton destructor called" << endl;
    }

public :

    static Singleton* getInstance(){
        if(instance != NULL) return instance;
        instance = new Singleton();
        return instance;
    }

    void showMessage(){
        cout << "From Singleton class" << endl;
    }
    
};

Singleton* Singleton::instance = NULL;

int main(){

    Singleton* singletonClass = Singleton::getInstance();
    singletonClass->showMessage();
    return 0;

}