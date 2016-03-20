import java.io.FileOutputStream;
import java.util.*;
import java.util.List;


public class HomeWorkEE1 {

    private Random random;
    private long startTime;
    private long endTime;
    private int randomIndex;
    private int countTestStep;

    public void init() {
        random = new Random();
        startTime = 0;
        endTime   = 0;
        randomIndex = 0;
        countTestStep = 100;
    }

    public static void main(String[] args) {
        HomeWorkEE1 hwa = new HomeWorkEE1();
        hwa.init();

        hwa.test(10000);
        hwa.test(100000);
        hwa.test(1000000);
    }

    public void test(int lengthForTest) {

        StringBuilder resultText = new StringBuilder();
        long[][] results = new long[4][7];

        results[0][0] = arrayAddIndexTime(lengthForTest,1);
        results[0][1] = arrayGetIndexTime(lengthForTest);
        results[0][2] = arrayRemoveIndexTime(lengthForTest);
        results[0][3] = arrayContainsTime(lengthForTest);
        results[0][4] = arrayPopulateTime(lengthForTest);
        results[0][5] = arrayIteratorAddTime(lengthForTest);
        results[0][6] = arrayIteratorRemoveTime(lengthForTest);
        results[1][0] = linkedListAddIndexTime(lengthForTest,1);
        results[1][1] = linkedListGetIndexTime(lengthForTest);
        results[1][2] = linkedListRemoveIndexTime(lengthForTest);
        results[1][3] = linkedListContainsTime(lengthForTest);
        results[1][4] = linkedListPopulateTime(lengthForTest);
        results[1][5] = linkedListIteratorAddTime(lengthForTest);
        results[1][6] = linkedListIteratorRemoveTime(lengthForTest);
        results[2][0] = hashSetAddTime(lengthForTest);
        results[2][1] = hashSetGetTime(lengthForTest);
        results[2][2] = hashSetRemoveTime(lengthForTest);
        results[2][3] = hashSetContainsTime(lengthForTest);
        results[2][4] = hashSetPopulateTime(lengthForTest);
        results[3][0] = treeSetAddTime(lengthForTest);
        results[3][1] = treeSetGetTime(lengthForTest);
        results[3][2] = treeSetRemoveTime(lengthForTest);
        results[3][3] = treeSetContainsTime(lengthForTest);
        results[3][4] = treeSetPopulateTime(lengthForTest);


        resultText.append("Test for " + lengthForTest + " elements. Time in milliseconds");
        resultText.append('\n');
        resultText.append("----------------------------------------------------------------------------------");
        resultText.append('\n');
        resultText.append("            add   get   remove   contains  populate  iterator.add  iterator.remove");
        resultText.append('\n');
        resultText.append("ArrayList   " + results[0][0] + "     " + results[0][1] + "    " + results[0][2] + "         " + results[0][3] + "          "
                + results[0][4] + "         " + results[0][5] + "           " + results[0][6]);
        resultText.append('\n');

        resultText.append("LinkedList  " + results[1][0] + "     " + results[1][1] + "    " + results[1][2] + "         " + results[1][3] + "          "
                + results[1][4] + "         " + results[1][5] + "           " + results[1][6]);
        resultText.append('\n');

        resultText.append("HashSet     " + results[2][0] + "     " + results[2][1] + "    " + results[2][2] + "         " + results[2][3] + "          "
                + results[2][4] + "         ");
        resultText.append('\n');

        resultText.append("TreeSet     " + results[3][0] + "     " + results[3][1] + "    " + results[3][2] + "         " + results[3][3] + "          "
                + results[3][4] + "         ");
        resultText.append('\n');

        System.out.println(resultText.toString());
        saveResultToFile("resultTestFor_" + lengthForTest + ".txt",resultText.toString());
    }

    public void saveResultToFile(String fileName,String text) {

        try
        {
            FileOutputStream fos = new FileOutputStream("C://" + fileName);
            byte[] buffer = text.getBytes();
            fos.write(buffer, 0, buffer.length);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }


//блок ArrayList

    // modeTest - режим тестирования.
    // 0 - вставка в нулевой индекс
    // 1 - вставка в случайный индекс
    // 2 - вставка в последний индекс
    public long arrayAddIndexTime(int length, int modeTest) {
        long result = 0;
        long[] arrayTimes = new long[countTestStep];
        List arrayList = new ArrayList();

        if (modeTest == 0) {
            for (int i = 0; i < countTestStep; i++) {
                arrayList = new ArrayList();

                startTime = System.currentTimeMillis();
                for (int step = 0; step < length; step++) {
                    arrayList.add(0,step);
                }
                endTime = System.currentTimeMillis();
                arrayTimes[i] = endTime - startTime;
            }
        }

        if (modeTest == 1) {
            for (int i = 0; i < countTestStep; i++) {
                arrayList = new ArrayList();

                startTime = System.currentTimeMillis();
                for (int step = 0; step < length; step++) {
                    randomIndex = random.nextInt(length);

                    if (arrayList.size() < randomIndex) {
                        for(int index = arrayList.size(); index < randomIndex;index++) {
                            arrayList.add(null);
                              }
                    }

                    arrayList.add(randomIndex, step);
                }
                endTime = System.currentTimeMillis();
                arrayTimes[i] = endTime - startTime;
            }
        }

        if (modeTest == 2) {
            for (int i = 0; i < countTestStep; i++) {
                arrayList = new ArrayList();

                startTime = System.currentTimeMillis();
                for (int step = 0; step < length; step++) {
                    if (arrayList.size() < length) {
                        for(int index = arrayList.size(); index < length;index++) {
                            arrayList.add(null);
                        }
                    }
                    arrayList.add(length, step);
                }
                endTime = System.currentTimeMillis();
                arrayTimes[i] = endTime - startTime;
            }
        }

        for (long tmp:arrayTimes) {
            result += tmp;
        }

        if(result > 0) {
            result = result / countTestStep;
        }

        return result;
    }

    public long arrayGetIndexTime(int length) {
        long result = 0;
        long[] arrayTimes = new long[countTestStep];

        List arrayList = new ArrayList();
        for(int i = 0; i < length; i++) {
            arrayList.add(i);
        }

        for(int i = 0;i < countTestStep;i++) {
            randomIndex = random.nextInt(length);

            startTime = System.currentTimeMillis();
            arrayList.get(randomIndex);
            endTime = System.currentTimeMillis();

            arrayTimes[i] = endTime - startTime;
        }

        for (long tmp:arrayTimes) {
            result += tmp;
        }

        if(result > 0) {
            result = result / countTestStep;
        }

        return result;
    }


    public long arrayRemoveIndexTime(int length) {
        long result = 0;
        long[] arrayTimes = new long[countTestStep];

        List arrayList = new ArrayList();
        for(int i = 0; i < length; i++) {
            arrayList.add(i);
        }

        for(int i = 0;i < countTestStep;i++) {
            randomIndex = random.nextInt(length);
            startTime = System.currentTimeMillis();
            if(randomIndex < arrayList.size()) {
                arrayList.remove(randomIndex);
            }
            endTime = System.currentTimeMillis();
            arrayTimes[i] = endTime - startTime;
        }

        for (long tmp:arrayTimes) {
            result += tmp;
        }

        if(result > 0) {
            result = result / countTestStep;
        }

        return result;
    }


    public long arrayContainsTime(int length) {
        long result = 0;
        long[] arrayTimes = new long[countTestStep];
        int randomValue;
        List arrayList = new ArrayList();
        for(int i = 0; i < length; i++) {
            arrayList.add(i);
        }

        for(int i = 0;i < countTestStep;i++) {
            randomValue = random.nextInt(length);
            Iterator iterator = arrayList.iterator();

            startTime = System.currentTimeMillis();
            while (iterator.hasNext()) {
                if(iterator.next().equals(randomValue)) {
                    break;
                }
            }

            endTime = System.currentTimeMillis();
            arrayTimes[i] = endTime - startTime;
        }

        for (long tmp:arrayTimes) {
            result += tmp;
        }

        if(result > 0) {
            result = result / countTestStep;
        }

        return result;
    }

    public long arrayPopulateTime(int length) {
        long result = 0;
        long[] arrayTimes = new long[countTestStep];
        List arrayList;

        for(int i = 0;i < countTestStep;i++) {
            arrayList = new ArrayList();
            startTime = System.currentTimeMillis();
            for(int j = 0; j < length; j++) {
                arrayList.add(j);
            }
            endTime = System.currentTimeMillis();
            arrayTimes[i] = endTime - startTime;
        }

        for (long tmp:arrayTimes) {
            result += tmp;
        }

        if(result > 0) {
           result = result / countTestStep;
        }

        return result;
    }

    public long arrayIteratorAddTime(int length) {
        long result = 0;
        long[] arrayTimes = new long[countTestStep];
        List arrayList;
        ListIterator iterator;

        for(int i = 0;i < countTestStep;i++) {
            arrayList = new ArrayList();

            for(int j = 0; j < length; j++) {
                arrayList.add(j);
            }
            randomIndex = random.nextInt(length);
            iterator = arrayList.listIterator();

            startTime = System.currentTimeMillis();
            iterator.add(randomIndex);
            endTime = System.currentTimeMillis();
            arrayTimes[i] = endTime - startTime;
        }

        for (long tmp:arrayTimes) {
            result += tmp;
        }

        if(result > 0) {
            result = result / countTestStep;
        }

        return result;
    }


    public long arrayIteratorRemoveTime(int length) {
        long result = 0;
        long[] arrayTimes = new long[countTestStep];
        List arrayList;
        Iterator iterator;


        for(int i = 0;i < countTestStep;i++) {
            arrayList = new ArrayList();
            for(int j = 0; j < length; j++) {
                arrayList.add(j);
            }
            randomIndex = random.nextInt(length);
            iterator = arrayList.iterator();

            startTime = System.currentTimeMillis();
            while (iterator.hasNext()) {
                if(iterator.next().equals(randomIndex)) {
                    iterator.remove();
                    break;
                }
            }

            endTime = System.currentTimeMillis();
            arrayTimes[i] = endTime - startTime;
        }

        for (long tmp:arrayTimes) {
            result += tmp;
        }

        if(result > 0) {
           result = result / countTestStep;
        }

        return result;
    }



//блок LinkedList

    public long linkedListAddIndexTime(int length, int modeTest) {
        long result = 0;
        long[] arrayTimes = new long[countTestStep];
        List linkedList = new LinkedList();

        if (modeTest == 0) {
            for (int i = 0; i < countTestStep; i++) {
                linkedList = new ArrayList();

                startTime = System.currentTimeMillis();
                for (int step = 0; step < length; step++) {
                    linkedList.add(0,step);
                }
                endTime = System.currentTimeMillis();
                arrayTimes[i] = endTime - startTime;
            }
        }

        if (modeTest == 1) {
            for (int i = 0; i < countTestStep; i++) {
                linkedList = new ArrayList();

                startTime = System.currentTimeMillis();
                for (int step = 0; step < length; step++) {
                    randomIndex = random.nextInt(length);

                    if (linkedList.size() < randomIndex) {
                        for(int index = linkedList.size(); index < randomIndex;index++) {
                            linkedList.add(null);
                        }
                    }

                    linkedList.add(randomIndex, step);
                }
                endTime = System.currentTimeMillis();
                arrayTimes[i] = endTime - startTime;
            }
        }

        if (modeTest == 2) {
            for (int i = 0; i < countTestStep; i++) {
                linkedList = new ArrayList();

                startTime = System.currentTimeMillis();
                for (int step = 0; step < length; step++) {
                    if (linkedList.size() < length) {
                        for(int index = linkedList.size(); index < length;index++) {
                            linkedList.add(null);
                        }
                    }
                    linkedList.add(length, step);
                }
                endTime = System.currentTimeMillis();
                arrayTimes[i] = endTime - startTime;
            }
        }

        for (long tmp:arrayTimes) {
            result += tmp;
        }

        if(result > 0) {
            result = result / countTestStep;
        }

        return result;
    }

    public long linkedListGetIndexTime(int length) {
        long result = 0;
        long[] arrayTimes = new long[countTestStep];

        List linkedList = new LinkedList();
        for(int i = 0; i < length; i++) {
            linkedList.add(i);
        }

        for(int i = 0;i < countTestStep;i++) {
            randomIndex = random.nextInt(length);

            startTime = System.currentTimeMillis();
            linkedList.get(randomIndex);
            endTime = System.currentTimeMillis();

            arrayTimes[i] = endTime - startTime;
        }

        for (long tmp:arrayTimes) {
            result += tmp;
        }

        if(result > 0) {
            result = result / countTestStep;
        }

        return result;
    }


    public long linkedListRemoveIndexTime(int length) {
        long result = 0;
        long[] arrayTimes = new long[countTestStep];

        List linkedList = new LinkedList();
        for(int i = 0; i < length; i++) {
            linkedList.add(i);
        }

        for(int i = 0;i < countTestStep;i++) {
            randomIndex = random.nextInt(length);
            startTime = System.currentTimeMillis();
            if(randomIndex < linkedList.size()) {
                linkedList.remove(randomIndex);
            }
            endTime = System.currentTimeMillis();
            arrayTimes[i] = endTime - startTime;
        }

        for (long tmp:arrayTimes) {
            result += tmp;
        }

        if(result > 0) {
            result = result / countTestStep;
        }

        return result;
    }


    public long linkedListContainsTime(int length) {
        long result = 0;
        long[] arrayTimes = new long[countTestStep];
        int randomValue;
        List linkedList = new LinkedList();
        for(int i = 0; i < length; i++) {
            linkedList.add(i);
        }

        for(int i = 0;i < countTestStep;i++) {
            randomValue = random.nextInt(length);
            Iterator iterator = linkedList.iterator();

            startTime = System.currentTimeMillis();
            while (iterator.hasNext()) {
                if(iterator.next().equals(randomValue)) {
                    break;
                }
            }

            endTime = System.currentTimeMillis();
            arrayTimes[i] = endTime - startTime;
        }

        for (long tmp:arrayTimes) {
            result += tmp;
        }

        if(result > 0) {
            result = result / countTestStep;
        }

        return result;
    }


    public long linkedListPopulateTime(int length) {
        long result = 0;
        long[] arrayTimes = new long[countTestStep];
        List linkedList;

        for(int i = 0;i < countTestStep;i++) {
            linkedList = new LinkedList();
            startTime = System.currentTimeMillis();
            for(int j = 0; j < length; j++) {
                linkedList.add(j);
            }
            endTime = System.currentTimeMillis();
            arrayTimes[i] = endTime - startTime;
        }

        for (long tmp:arrayTimes) {
            result += tmp;
        }

        if(result > 0) {
           result = result / countTestStep;
        }

        return result;
    }

    public long linkedListIteratorAddTime(int length) {
        long result = 0;
        long[] arrayTimes = new long[countTestStep];
        List linkedList;
        ListIterator iterator;

        for(int i = 0;i < countTestStep;i++) {
            linkedList = new LinkedList();

            for(int j = 0; j < length; j++) {
                linkedList.add(j);
            }

            iterator = linkedList.listIterator();
            randomIndex = random.nextInt(length);

            startTime = System.currentTimeMillis();
            iterator.add(randomIndex);
            endTime = System.currentTimeMillis();
            arrayTimes[i] = endTime - startTime;
        }

        for (long tmp:arrayTimes) {
            result += tmp;
        }

        if(result > 0) {
            result = result / countTestStep;
        }

        return result;
    }


    public long linkedListIteratorRemoveTime(int length) {
        long result = 0;
        long[] arrayTimes = new long[countTestStep];
        List linkedList;
        Iterator iterator;

        for(int i = 0;i < countTestStep;i++) {
            linkedList = new ArrayList();
            for(int j = 0; j < length; j++) {
                linkedList.add(j);
            }
            randomIndex = random.nextInt(length);
            iterator = linkedList.iterator();

            startTime = System.currentTimeMillis();
            while (iterator.hasNext()) {
                if(iterator.next().equals(randomIndex)) {
                    iterator.remove();
                    break;
                }
            }

            endTime = System.currentTimeMillis();
            arrayTimes[i] = endTime - startTime;
        }

        for (long tmp:arrayTimes) {
            result += tmp;
        }

        if(result > 0) {
            result = result / countTestStep;
        }

        return result;
    }

//блок HashSet

    public long hashSetAddTime(int length) {
        long result = 0;
        long[] arrayTimes = new long[countTestStep];

        Set hashSet = new HashSet();

        for(int i = 0;i < countTestStep;i++) {
            randomIndex = random.nextInt(length-1);

            startTime = System.currentTimeMillis();
            hashSet.add(randomIndex);
            endTime = System.currentTimeMillis();
            arrayTimes[i] = endTime - startTime;
        }

        for (long tmp:arrayTimes) {
            result += tmp;
        }

        if(result > 0) {
           result = result / countTestStep;
        }

        return result;
    }

    public long hashSetGetTime(int length) {
        long result = 0;
        long[] arrayTimes = new long[countTestStep];
        Iterator iterator;
        Set hashSet = new HashSet();
        for(int i = 0; i < length; i++) {
            hashSet.add(i);
        }

        iterator = hashSet.iterator();

        for(int i = 0;i < countTestStep;i++) {
            randomIndex = random.nextInt(length);

            startTime = System.currentTimeMillis();
            while (iterator.hasNext()) {
                if(iterator.next().equals(randomIndex)) {
                    break;
                }
            }
            endTime = System.currentTimeMillis();

            arrayTimes[i] = endTime - startTime;
        }

        for (long tmp:arrayTimes) {
            result += tmp;
        }

        if(result > 0) {
           result = result / countTestStep;
        }

        return result;
    }


    public long hashSetRemoveTime(int length) {
        long result = 0;
        long[] arrayTimes = new long[countTestStep];

        for(int i = 0;i < countTestStep;i++) {
            Set hashSet = new HashSet();
            for(int j = 0; j < length; j++) {
                hashSet.add(j);
            }

            randomIndex = random.nextInt(length-1);
            startTime = System.currentTimeMillis();
            hashSet.remove(randomIndex);
            endTime = System.currentTimeMillis();
            arrayTimes[i] = endTime - startTime;
        }

        for (long tmp:arrayTimes) {
            result += tmp;
        }

        if(result > 0) {
            result = result / countTestStep;
        }

        return result;
    }

    public long hashSetContainsTime(int length) {
        long result = 0;
        long[] arrayTimes = new long[countTestStep];
        int randomValue;
        Set hashSet = new HashSet();
        for(int i = 0; i < length; i++) {
            hashSet.add(i);
        }

        for(int i = 0;i < countTestStep;i++) {
            randomValue = random.nextInt(length);
            Iterator iterator = hashSet.iterator();

            startTime = System.currentTimeMillis();
            while (iterator.hasNext()) {
                if(iterator.next().equals(randomValue)) {
                    break;
                }
            }

            endTime = System.currentTimeMillis();
            arrayTimes[i] = endTime - startTime;
        }

        for (long tmp:arrayTimes) {
            result += tmp;
        }

        if(result > 0) {
            result = result / countTestStep;
        }

        return result;
    }

    public long hashSetPopulateTime(int length) {
        long result = 0;
        long[] arrayTimes = new long[countTestStep];
        Set hashSet ;

        for(int i = 0;i < countTestStep;i++) {
            hashSet = new HashSet();
            startTime = System.currentTimeMillis();
            for(int j = 0; j < length; j++) {
                hashSet.add(j);
            }
            endTime = System.currentTimeMillis();
            arrayTimes[i] = endTime - startTime;
        }

        for (long tmp:arrayTimes) {
            result += tmp;
        }

        if(result > 0) {
           result = result / countTestStep;
        }

        return result;
    }

//блок TreeSet

    public long treeSetAddTime(int length) {
        long result = 0;
        long[] arrayTimes = new long[countTestStep];

        for(int i = 0;i < countTestStep;i++) {
            Set treeSet = new TreeSet();
            startTime = System.currentTimeMillis();
            for(int j = 0; j < length;j++) {
                randomIndex = random.nextInt(length-1);
                treeSet.add(randomIndex);
            }
            endTime = System.currentTimeMillis();
            arrayTimes[i] = endTime - startTime;
        }

        for (long tmp:arrayTimes) {
            result += tmp;
        }

        if(result > 0) {
            result = result / countTestStep;
        }

        return result;
    }


    public long treeSetGetTime(int length) {
        long result = 0;
        long[] arrayTimes = new long[countTestStep];
        Iterator iterator;
        Set treeSet = new HashSet();
        for(int i = 0; i < length; i++) {
            treeSet.add(i);
        }

        iterator = treeSet.iterator();

        for(int i = 0;i < countTestStep;i++) {
            randomIndex = random.nextInt(length);

            startTime = System.currentTimeMillis();
            while (iterator.hasNext()) {
                if(iterator.next().equals(randomIndex)) {
                    break;
                }
            }
            endTime = System.currentTimeMillis();

            arrayTimes[i] = endTime - startTime;
        }

        for (long tmp:arrayTimes) {
            result += tmp;
        }

        if(result > 0) {
           result = result / countTestStep;
        }

        return result;
    }

    public long treeSetRemoveTime(int length) {
        long result = 0;
        long[] arrayTimes = new long[countTestStep];

        for(int i = 0;i < countTestStep;i++) {
            Set treeSet = new TreeSet();
            for(int j = 0; j < length; j++) {
                treeSet.add(j);
            }

            randomIndex = random.nextInt(length-1);
            startTime = System.currentTimeMillis();
            treeSet.remove(randomIndex);
            endTime = System.currentTimeMillis();
            arrayTimes[i] = endTime - startTime;
        }

        for (long tmp:arrayTimes) {
            result += tmp;
        }

        if(result > 0) {
           result = result / countTestStep;
        }

        return result;
    }

    public long treeSetContainsTime(int length) {
        long result = 0;
        long[] arrayTimes = new long[countTestStep];
        int randomValue;
        Set treeSet = new TreeSet();
        for(int i = 0; i < length; i++) {
            treeSet.add(i);
        }

        for(int i = 0;i < countTestStep;i++) {
            randomValue = random.nextInt(length);
            Iterator iterator = treeSet.iterator();

            startTime = System.currentTimeMillis();
            while (iterator.hasNext()) {
                if(iterator.next().equals(randomValue)) {
                    break;
                }
            }

            endTime = System.currentTimeMillis();
            arrayTimes[i] = endTime - startTime;
        }

        for (long tmp:arrayTimes) {
            result += tmp;
        }

        if(result > 0) {
           result = result / countTestStep;
        }

        return result;
    }

    public long treeSetPopulateTime(int length) {
        long result = 0;
        long[] arrayTimes = new long[countTestStep];
        Set treeSet ;

        for(int i = 0;i < countTestStep;i++) {
            treeSet = new HashSet();
            startTime = System.currentTimeMillis();
            for(int j = 0; j < length; j++) {
                treeSet.add(j);
            }
            endTime = System.currentTimeMillis();
            arrayTimes[i] = endTime - startTime;
        }

        for (long tmp:arrayTimes) {
            result += tmp;
        }

        if(result > 0) {
            result = result / countTestStep;
        }

        return result;
    }


}
