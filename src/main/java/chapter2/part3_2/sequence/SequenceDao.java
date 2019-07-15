package chapter2.part3_2.sequence;

public interface SequenceDao {

	public Sequence getSequence(String sequenceId);

	public int getNextValue(String sequenceId);
}
