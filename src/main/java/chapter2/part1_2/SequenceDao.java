package chapter2.part1_2;

public interface SequenceDao {
	public Sequence getSequence(String sequenceId);

	public int getNextValue(String sequenceId);
}
