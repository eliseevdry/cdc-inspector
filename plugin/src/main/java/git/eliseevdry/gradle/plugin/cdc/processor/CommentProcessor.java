package git.eliseevdry.gradle.plugin.cdc.processor;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtComment;
import spoon.support.Level;

import static spoon.reflect.code.CtComment.CommentType.BLOCK;
import static spoon.reflect.code.CtComment.CommentType.FILE;
import static spoon.reflect.code.CtComment.CommentType.JAVADOC;

public class CommentProcessor extends AbstractProcessor<CtComment> {

    private final boolean withJavadoc;
    private final boolean withLicence;
    private final boolean withBlocks;

    private long totalCommentLength = 0L;

    public CommentProcessor(boolean withJavadoc, boolean withLicence, boolean withBlocks) {
        this.withJavadoc = withJavadoc;
        this.withLicence = withLicence;
        this.withBlocks = withBlocks;
    }

    @Override
    public void process(CtComment comment) {
        if (!withJavadoc && comment.getCommentType() == JAVADOC ||
            !withLicence && comment.getCommentType() == FILE ||
            !withBlocks && comment.getCommentType() == BLOCK) {
            return;
        }
        totalCommentLength = totalCommentLength + comment.getContent().length();
        if (comment.getCommentType() == JAVADOC) {
            getFactory().getEnvironment().report(this, Level.WARN, comment, "Javadoc was find");
        }
    }
}
