/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.mr.activiti.junit4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ExecutionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiRule;
import org.activiti.engine.test.Deployment;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author xuejiangtao
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:cn/mr/activiti/junit4/context-activiti.xml" })
public class ActivitiTest {

    @Autowired
    private ProcessEngine processEngine;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    @Rule
    public ActivitiRule activitiSpringRule;

    @After
    public void closeProcessEngine() {
        // Required, since all the other tests seem to do a specific drop on the
        // end
        processEngine.close();
    }

    @Test
    @Deployment(resources = { "cn/mr/activiti/junit4/WF_902.bpmn20.xml" })
    public void simpleProcessTest() {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("PROCESS_902");
        Task task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        System.out.println("InstanceId=" + task.getProcessInstanceId() + ";taskId=" + task.getId() + ";taskName="
                + task.getName());
        ExecutionQuery executionQuery = runtimeService.createExecutionQuery()
                .processInstanceId(processInstance.getId());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("SUBPROCESS_LOOPCARDINALITY_1708", 2);
        map.put("asdfasdf", 1222);
        taskService.complete(task.getId(), map);

        task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        System.out.println("InstanceId=" + task.getProcessInstanceId() + ";taskId=" + task.getId() + ";taskName="
                + task.getName());
        map = new HashMap<String, Object>();
        map.put("NEXTWFSTEPID", 1709);
        map.put("SUBPROCESS_LOOPCARDINALITY_1708", 2);
        taskService.complete(task.getId(), map);

        List<Task> tasks = taskService.createTaskQuery().processInstanceId(processInstance.getId()).list();
        for (Task task1 : tasks) {
            System.out.println("InstanceId=" + task1.getProcessInstanceId() + ";taskId=" + task1.getId() + ";taskName="
                    + task1.getName());
            taskService.complete(task1.getId());
        }

        tasks = taskService.createTaskQuery().processInstanceId(processInstance.getId()).list();
        for (Task task1 : tasks) {
            System.out.println("InstanceId=" + task1.getProcessInstanceId() + ";taskId=" + task1.getId() + ";taskName="
                    + task1.getName());
            taskService.complete(task1.getId());
        }
        tasks = taskService.createTaskQuery().processInstanceId(processInstance.getId()).list();
        /*
         * System.out.println(task.getName()); taskService.complete(task.getId());
         */

        /*
         * task = taskService.createTaskQuery().processInstanceId( processInstance.getId()).singleResult();
         * System.out.println(task.getName()); taskService.complete(task.getId());
         */
    }

}
