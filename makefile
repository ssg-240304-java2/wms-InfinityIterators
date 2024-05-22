GRADLE = ./gradlew

all: clean bld

bld:
    $(GRADLE) build

clean:
	$(GRADLE) clean

run:
    java -jar build/libs/MiniProject-0.0.1-SNAPSHOT.jar