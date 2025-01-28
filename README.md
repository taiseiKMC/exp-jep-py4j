# Abst
java から python の呼び出しを, jep, py4j で比較

```
% python --version
Python 3.10.15

% java -version
java version "17.0.12" 2024-07-16 LTS
Java(TM) SE Runtime Environment (build 17.0.12+8-LTS-286)
Java HotSpot(TM) 64-Bit Server VM (build 17.0.12+8-LTS-286, mixed mode, sharing)

% mvn -version
Apache Maven 3.9.9 (8e8579a9e76f7d015ee5ec7bfcdc97d260186937)
Maven home: /home/sugina/.sdkman/candidates/maven/current
Java version: 17.0.12, vendor: Oracle Corporation, runtime: /home/sugina/.sdkman/candidates/java/17.0.12-oracle
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "5.15.0-130-generic", arch: "amd64", family: "unix"

% kscript -v
Version   : 4.2.3 
Build     : 2023-07-22T13:06:02.327407526Z
Kotlin    : 1.9.24-release-822
Java      : JRE 17.0.12+8
```

## 計測コード
1000 要素の `ArrayList<Double>` を python へ渡し、そのまま java へ返す関数を 1000000 回実行し、時間を計測

### exp-jep
```
% cd exp-jep
% mvn install
% kscript exec.kts
1891 ms
```

### exp-py4j
```
% cd exp-py4j
% mvn install
% python exp.py &
% kscript exec.kts
44329 ms
```