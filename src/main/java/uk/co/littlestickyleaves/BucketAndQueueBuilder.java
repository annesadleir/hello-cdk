package uk.co.littlestickyleaves;

import software.amazon.awscdk.Construct;
import software.amazon.awscdk.PhysicalName;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.s3.Bucket;
import software.amazon.awscdk.services.s3.BucketProps;
import software.amazon.awscdk.services.sns.Topic;
import software.amazon.awscdk.services.sns.TopicProps;
import software.amazon.awscdk.services.sqs.Queue;
import software.amazon.awscdk.services.sqs.QueueProps;

import javax.annotation.Nullable;
import java.util.Stack;

public class BucketAndQueueBuilder {

    public void andBucketAndQueueToConstruct(Construct construct) {

        Queue queue = new Queue(construct, "MyFirstQueue", QueueProps.builder()
                .withVisibilityTimeoutSec(300)
                .build());

        Topic topic = new Topic(construct, "MyFirstTopic", TopicProps.builder()
                .withDisplayName("My First Topic Yeah")
                .build());

        Bucket bucket = new Bucket(construct, "MyFirstBucket", BucketProps.builder()
                .withVersioned(true)
                .withBucketName(PhysicalName.of("theName"))
                .build());
    }


}
