package domain;
public class EmpVO {
	// VO : Value Object
	// 데이터베이스의 데이터 테이블 기준으로
	// 같은 명칭을 사용하여 변수를 정의함으로써
	// 데이터의 정확성을 높이는 작업
	// 서비스에 필요한 데이터를 통일된 형식으로 관리
	
	private int empno; // 회원 id로 사용할 예정
	private String pwd;
	private String ename;
	private String job;
	private int mgr;
	private String hiredate;
	private double sal;
	private double comm;
	private int deptno;
	
	public EmpVO() {}
	
	// register
	public EmpVO(int empno, String pwd, String ename) {
		this.empno = empno;
		this.pwd = pwd;
		this.ename = ename;
	}
	
	// login_auth
	public EmpVO(String ename, String job, int empno) {
		this.ename = ename;
		this.job = job;
		this.empno = empno;
	}

	// list
	public EmpVO(int empno, String ename, String hiredate, int deptno) {
		this.empno = empno;
		this.ename = ename;
		this.hiredate = hiredate;
		this.deptno = deptno;
	}

	// modify
	public EmpVO(int empno, String job, int mgr, double sal, double comm, int deptno) {
		this.empno = empno;
		this.job = job;
		this.mgr = mgr;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}

	// detail
	public EmpVO(int empno, String pwd, String ename, String job, int mgr, String hiredate, double sal, double comm,
			int deptno) {
		this(empno, job, mgr, sal, comm, deptno);
		this.pwd = pwd;
		this.ename = ename;
		this.hiredate = hiredate;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	public double getComm() {
		return comm;
	}

	public void setComm(double comm) {
		this.comm = comm;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
}
