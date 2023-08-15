class A {
    int a;
    int d;
public:
    int b() {
        return this->d;
    }
};

int main() {
    int c = 1;
    A x[10];
    x[1].b();
    A y;
    y.b();
    return x[0].b();
}