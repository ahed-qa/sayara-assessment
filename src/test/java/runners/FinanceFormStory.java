package runners;

import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.junit.runner.RunWith;
import org.jbehave.core.junit.AnnotatedEmbedderRunner;
import steps.jbehave.FinanceFormSteps;

import java.util.Arrays;
import java.util.List;

import static org.jbehave.core.reporters.Format.*;

@RunWith(AnnotatedEmbedderRunner.class)
public class FinanceFormStory extends JUnitStories {

    @Override
    public Configuration configuration() {
        return new org.jbehave.core.configuration.MostUsefulConfiguration()
                .useStoryLoader(new LoadFromClasspath(this.getClass()))
                .useStoryParser(new RegexStoryParser())
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withDefaultFormats()
                        .withFormats(CONSOLE, TXT, HTML));
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new FinanceFormSteps());
    }

    @Override
    public List<String> storyPaths() {
        return Arrays.asList("stories/finance_form.story");
    }
}
