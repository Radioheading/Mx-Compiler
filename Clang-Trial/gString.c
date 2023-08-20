char *s = "s";

int a = 0;
int foo() {
	return a;
}

int main() {
	int b = foo();
	int c = a + b;
	return c;
}