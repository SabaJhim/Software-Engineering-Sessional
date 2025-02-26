#include<iostream>
#include<string>
#include<fstream>
# define SIZE 50

using namespace std;


int main(){

        ofstream output("output.txt");
        string seed="XYZ";
        int initial=100;
        char init='a';
        string name="abc";

        for(int i=0;i<SIZE;i++){
                string tempID=seed+to_string(initial);
                string tempName=name+init;
                if(init=='z'){
                        name=tempName;
                        init='a';
                }
                initial++;
                init++;
                cout<<tempID<<","<<tempName<<endl;
                output<<tempID<<","<<tempName<<endl;

        }
}