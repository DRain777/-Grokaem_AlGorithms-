

public class MyLinkedList {

    private Node head;

    /**
     * Реализоват в классе MyLinkedList следующие методы
     * 1. public int size() - получение размера списка, проитерировався по всей
     * структуре
     * 1.1 * Можно завести переменную size, поддерживать ее и использовать ее.
     * 2. public boolean contains(int value) - проверка наличия элемента по значению
     * 3. public int popLast() - удаление последнего элемента. Если список пустой -
     * то ошибка
     * 4. * Переделать все int значения на дженерик T, чтобы можно было хранить
     * значения любых типов
     * 5. * public MyLinkedList reversed() - создать НОВЫЙ список, порядок в котором
     * обратный текущему
     */

    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void add(int value) {
        Node last = findLast();
        if (last == null) {
            head = new Node(value);
        } else {
            last.next = new Node(value);
        }
    }

    public int getFirst() {
        return get(0);
    }

    public int get(int index) {
        if (head == null) {
            throw new IllegalStateException("Список пустой");
        } else if (index < 0) {
            throw new IndexOutOfBoundsException(index);
        }

        Node cursor = head;
        int indexCursor = 0;
        while (cursor != null) {
            if (indexCursor == index) {
                return cursor.value;
            }

            cursor = cursor.next;
            indexCursor++;
        }

        throw new IndexOutOfBoundsException(index);
    }

    public int popFirst() {
        return pop(0);
    }

    public int pop(int index) {
        if (head == null) {
            throw new IllegalStateException("Список пустой");
        } else if (index < 0) {
            throw new IndexOutOfBoundsException(index);
        }

        if (index == 0) {
            int pop = head.value;
            head = head.next;
            return pop;
        }

        Node cursor = head;
        int indexCursor = 1;
        while (cursor.next != null) {
            if (indexCursor == index) {
                int pop = cursor.next.value;
                cursor.next = cursor.next.next;
                return pop;
            }

            cursor = cursor.next;
            indexCursor++;
        }

        throw new IndexOutOfBoundsException(index);
    }

    public boolean contains(int value) {
        Node cursor = head;
        while (cursor != null) {
            if (cursor.value == value) {
                return true;
            }
            cursor = cursor.next;
        }
        return false;
    }

    public int popLast() {
        if (head == null) {
            throw new IllegalStateException("Список пустой");
        }
        if (head.next == null) {
            int pop = head.value;
            head = null;
            return pop;
        }
        Node cursor = head;
        while (cursor.next.next != null) {
            cursor = cursor.next;
        }
        int pop = cursor.next.value;
        cursor.next = null;
        return pop;
    }

    public MyLinkedList reversed() {
        MyLinkedList reversedList = new MyLinkedList();
        Node cursor = head;
        while (cursor != null) {
            reversedList.addFirst(cursor.value);
            cursor = cursor.next;
        }
        return reversedList;
    }

    public void addFirst(int value) {
        head = new Node(value, head);
    }
   

    private Node findLast() {
        if (head == null) {
            return null;
        }

        Node cursor = head;
        while (cursor.next != null) {
            cursor = cursor.next;
        }
        return cursor;
    }

    @Override
    public String toString() {
        // [1 -> 2 -> 3 -> 4 -> 5 -> ]
        StringBuilder result = new StringBuilder("[");
        Node cursor = head;
        while (cursor != null) {
            result.append(cursor.value).append(" -> ");
            cursor = cursor.next;
        }

        int length = result.length();
        if (length > 4) {
            result.delete(length - 4, length);
        }

        result.append("]");
        return result.toString();
    }



    public int size() {
        int count = 0;
        Node cursor = head;
        while (cursor != null) {
            count++;
            cursor = cursor.next;
        }
        return count;
    }



}