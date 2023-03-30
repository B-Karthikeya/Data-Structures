#include<stdio.h>
#include<stdlib.h>

struct queue{
    int size;
    int f;
    int r ;
    int* arr;
};

void enqueue(struct queue *q){
    int element;
    if(q->f == -1 && q->r == -1) 
    {
        q->f++;
        q->r++;
        printf("enter the element :");
        scanf("%d",&element);
        q->arr[q->r] = element;

    }
    else if((q->r+1)%q->size == q->f) printf("QUEUE IS FULL\n");
    else {
        
        printf("enter the element :");
        scanf("%d",&element);
        q->r = (q->r+1)%q->size;
        q->arr[q->r] = element;
    }
}
int dequeue(struct queue *q){
    int a = -1;
    if(q->f == -1 && q->r == -1) printf("QUEUE IS EMPTY\n");
    else if (q->f == q->r) q->f = q->r = -1;
    else{
        q->f = (q->f+1)%q->size;
        a = q->arr[q->f];
    }
    return a;
}
void display(struct queue *q){
    printf("QUEUE : ");
    if(q->f == -1 && q->r == -1) printf("QUEUE IS EMPTY\n");
    else {
        int i = q->f;
        while(i%q->size!=q->r){
            printf("%d\t",q->arr[i]);
            i++;
        }
        printf("%d\n",q->arr[i]);
    }
}

int main(){
    int n,choice;
    struct queue *q = (struct queue *)malloc(sizeof(struct queue));
    printf("enter the size of queue :");
    scanf("%d",&n);
    q->size = n;
    q->arr = (int *) malloc(n*sizeof(int));
    q->f = q->r = -1;

    printf("OPERATIONAL CODES :\n1-enqueue\n2-dequeue\n3-display\n0-exit");
    printf("enter the operational code :");
    scanf("%d",&choice);
    while(choice!=0){
        switch(choice) {
            case 1 : enqueue(q); break;
            case 2 : dequeue(q);break;
            case 3 : display(q);
            case 0 : exit;
            default : printf("enter valid operation");
        }
        
    printf("enter the operational code :");
        scanf("%d",&choice);
    }

    return 0;
}