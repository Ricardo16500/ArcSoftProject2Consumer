package bo.edu.ucb.Consumer.Dto;

import java.util.Objects;

public class Subject {
    private Integer subjectId;
    private String name;
    private Integer semester;
    private Integer credits;
    private Short status;

    public Subject() {
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Objects.equals(subjectId, subject.subjectId) && Objects.equals(name, subject.name) && Objects.equals(semester, subject.semester) && Objects.equals(credits, subject.credits) && Objects.equals(status, subject.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectId, name, semester, credits, status);
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", name='" + name + '\'' +
                ", semester=" + semester +
                ", credits=" + credits +
                ", status=" + status +
                '}';
    }
}
