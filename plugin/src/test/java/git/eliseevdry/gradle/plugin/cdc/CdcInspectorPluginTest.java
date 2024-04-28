/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package git.eliseevdry.gradle.plugin.cdc;

import org.gradle.testfixtures.ProjectBuilder;
import org.gradle.api.Project;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * A simple unit test for the 'git.eliseevdry.gradle.plugin.cdc.greeting' plugin.
 */
class CdcInspectorPluginTest {
    @Test void pluginRegistersATask() {
        // Create a test project and apply the plugin
        Project project = ProjectBuilder.builder().build();
        project.getPlugins().apply("git.eliseevdry.gradle.plugin.cdc.greeting");

        // Verify the result
        assertNotNull(project.getTasks().findByName("greeting"));
    }
}
