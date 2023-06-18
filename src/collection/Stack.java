package collection;

public class Stack {

	//스택용 배열
	private int[] stk;
	//스택 용량
	private int capacity;
	//스택 포인터
	private int ptr;
	
	//실행 시 예외 : 스택이 비어있는 경우
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {}
	}
	
	//실행 시 예외 : 스택이 가득 찬 경우
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {}
	}
	
	//생성자 : 최대 용량 설정, 포인터를 0에 위치, 스택용 배열의 길이를 최대 용량만큼으로 하여 생성
	//=> 메모리 부족 예외 발생 시 최대 용량을 다시 0으로 설정
	public Stack(int maxlen) {
		ptr = 0;
		capacity = maxlen;
		try {
			stk = new int[capacity];
		} catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}
	
	//스택에 x를 푸시
	public int push(int x) throws OverflowIntStackException {
		//스택 포인터가 최대 용량을 넘길 경우 OverflowIntStackException 예외 발생
		if (ptr >= capacity) {
			throw new OverflowIntStackException();
		}
		
		return stk[ptr++] = x;
	}
	
	//스택에서 데이터를 팝(맨 위의 데이터를 추출)
	public int pop() throws EmptyIntStackException {
		//스택 포인터가 0보다 작아질 경우 EmptyIntStackException 예외 발생
		if (ptr <= 0) {
			throw new EmptyIntStackException();
		}
		
		return stk[--ptr];
	}
	
	//스택에서 데이터를 피크(맨 위의 데이터를 확인)
	//데이터를 확인만 하고, 포인터는 변하지 않음
	public int peek() throws EmptyIntStackException {
		//스택 포인터가 0보다 작아질 경우 EmptyIntStackException 예외 발생
		if (ptr <= 0) {
			throw new EmptyIntStackException();
		}
		
		return stk[ptr - 1];
	}
	
	//스택을 비움
	//스택 포인터만 초기화시키면, 실제 데이터를 삭제하지 않아도 동일한 결과 발생
	public void clear() {
		ptr = 0;
	}
	
	//스택에서 x를 찾아 인덱스 반환
	public int indexOf(int x) {
		for (int i = ptr - 1; i >= 0; i--) {
			if (stk[i] == x) {
				return i;
			}
		}
		
		return -1;
	}
	
	//스택의 용량을 반환
	public int getCapacity() {
		return capacity;
	}
}
