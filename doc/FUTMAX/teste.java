javac src/Futebol.java

for i in {1..7}; do
    echo "Teste $i:"
    java src.Futebol < src/tests/in$i
done
